@[toc]
## lambda表达式简介
　　lambda有两个关键结构，第一个是lambda表达式自身，第二个是函数式接口。  
　　lambda表达式本质上就是一个匿名方法，用于实现由函数式接口定义的另一个方法。lambda表达式会导致产生
一个匿名类，lambda表达式也常被称为闭包。  
　　函数式接口是仅包含一个抽象方法的接口，这个方法指明了接口的目标用途，通常表示单个动作。如*Runnable*接口。
**此外，函数式接口定义了lambda表达式的目标类型。特别注意，lambda表达式只能用于其目标类型已被指定的上下文中。**  
> 注意：函数式接口可以指定Object定义的任何公有方法，例如equals()，而不影响其作为“函数式接口”的
状态。Object的公有方法被视为函数式接口的隐式成员，因为函数式接口的实例会默认自动实现它们。  
### lambda表达式基础知识
　　lambda表达式在Java语言中引入了一个新的语法元素和运算符。这个运算符是<b>-></b>，称为lambda运算符
或箭头运算符。它将lambda表达式分成两个部分。左侧指定了lambda表达式需要的所有参数；右侧是**lambda体**，
它指定了lambda表达式的动作。例如：
```
    (n) -> 1.0 / n;
    n -> (n % 2) == 0;
```
### 函数式接口
　　仅指定一个抽象方法的接口，可以包含默认方法或静态方法，但必须包含一个且仅包含一个抽象方法。
```java
    interface MyName {
        String getName();
    }
```
　　如前所述，lambda表达式不是独立执行的，而是构成了一个函数式接口定义的抽象方法的实现，该函数式接口定义了它的
目标类型。结果，只有再定义了lambda表达式的目标类型的上下文中，才能使用该表达式。当把一个lambda表达式赋给一个
函数式接口**引用**时，就创建了一个这样的上下文。其它目标类型上下文包括变量初始化、return语句和
方法实参等。对接口*MyName*的使用示例，
```
    // myName是对MyName实例的一个引用
    MyName myName = () -> "zzz";
    System.out.println("My name is " + myName.getName())
```
　　当目标类型上下文中出现lambda表达式时，会自动创建实现了函数式接口的一个类的实例，函数式接口声明的抽象方法
的行为由lambda表达式定义。当通过目标调用该方法时，就会执行lambda表达式。因此，lambda表达式提供了一种将代码
片段转换为对象的方法。
> 注意：为了在目标类型上下文中使用lambda表达式，抽象方法的类型和lambda的类型必须兼容。

### 代码示例
```java
    interface NumberTest {
        boolean test(int first, int second);
    }
    
    class LambdaDemo {
        public static void main(String[] args){
            NumberTest isFactor = (n, m) -> (n % m) == 0;
            if (isFactor.test(9, 3)) {
                System.out.println("2 is a factor of 10");
            }
        }
    }
```
> 注意：在需要显式声明形参的类型时，列表中所有形参的类型都必须已声明。  
```
    (int n, int d) -> (n % d) == 0; // 合法
    (int n, int d) -> (n % d) == 0; // 非法
```
## 块lambda表达式
　　箭头运算符->右侧的代码可以由一个代码块构成，可以包含多条语句，这种类型的lambda体称为块体(block body)，块lambda。
在块lambda中必须显式使用一条return语句来返回值。  
```
    NumberTest numberTest = (n, m) -> {
        boolean result;
        ……;
        return result;
    }
```
## 泛型函数式接口
　　lambda表达式自身不能指定类型形参，lambda表达式不能是泛型（由于存在类型推断，所有lambda表达式都展现出一些类似于泛型的特征）。
然而，与lambda表达式关联的函数式接口可以是泛型的。
```java
    interface Test<T> {
        boolean test(T param1, T param2);
    }
```
　　作为实参传递lambda表达式
```java
    interface StringTest {
        String test(String param);
    }
    
    class Demo {
        static String changeStr(StringTest st, String s) {
            return st.test(s);
        }
    
        public static void main(String[] args) {
            String inStr = "lambda in java";
            String outStr;
            StringTest reverse = (param) -> {
                StringBuilder sb = new StringBuilder();
                for(int i = param.length() - 1; i >= 0; i--) {
                    sb.append(param.charAt(i));
                }
                
                return sb.toString();
            };
            
            outStr = changeStr(reverse, inStr);
            outStr = changeStr((str) -> str.replace(' ', '-'), inStr);
        }
    }
```
## lambda表达式和变量捕获
　　lambda表达式可以获取或设置其外层**类的实例或静态变量的值**，以及调用其外层类定义的方法。
但是，当lambda表达式使用其外层作用域内定义的局部变量时，会产生一种特殊的情况，称为变量捕获，
只能**使用实质上为final的局部变量**。lambda表达式不能修改外层作用域内的局部变量。
```java
    interface MyTest {
        int test(int param);
    }
    
    class Demo {
        public static void main(String[] args){
            int num = 1;
            MyTest mt = (param) -> {
                int res = param + num;
                // illegal, can't modify the value of num;
                // num++;
                return res;
            };
            System.out.println(mt.test(10)); // 11
            // error, it would remove the effectively final status from num;
            // num = 0;
        }
    }
```
> lambda表达式可以使用和修改其调用类的实例变量，只是不能使用其外层作用域中的局部变量，
除非该变量实质上是final。
## 方法引用
### 静态方法的方法引用
　　类名后跟上方法名：ClassName::methodName。类名与方法名之间使用双冒号分隔开。
```java
    interface IntPredicate {
        boolean test(int num);
    }
    
    class MyIntPredicates {
        static boolean isEven(int num) {
            return num % 2 == 0;
        }
    }
    
    class Demo {
        static boolean numTest(IntPredicate p, int v) {
            return p.test(v);
        }
        
        public static void main(String[] args){
            boolean res = numTest(MyIntPredicates::isEven, 16);
            // ……
        }   
    }
```
### 实例方法的方法引用
　　objRef::methodName，由方法引用所引用的方法进行的操作针对的是objRef。指定对泛型方法的方法引用：
```java
    interface SomeTest<T> {
        boolean test(T param1, T param2);
    }
    
    class MyClass {
        static <T> boolean myGenMeth(T x, T y) {
            boolean result = false;
            // ……
            return result;
        }
        SomeTest<Integer> ref = MyClass::<Integer>myGenMeth;
    }
```
## 构造方法引用
　　ClassName::new
## 预定义的函数式接口
　　包名：java.util.function，接口：UnaryOperator<T>、BinaryOperator<T>、Consumer<T>、
Supplier<T>、Function<T, R>、Predicate<T>
流包：java.util.stream，流是数据的管道，流表示序列对象。允许创建管线（pipeline）来执行一系列针对
数据的动作，这些动作经常由lambda表达式来表示。这部分内容后面再介绍。

