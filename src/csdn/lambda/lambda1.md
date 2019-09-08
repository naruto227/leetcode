@[toc]
## lambda���ʽ���
����lambda�������ؼ��ṹ����һ����lambda���ʽ�����ڶ����Ǻ���ʽ�ӿڡ�  
����lambda���ʽ�����Ͼ���һ����������������ʵ���ɺ���ʽ�ӿڶ������һ��������lambda���ʽ�ᵼ�²���
һ�������࣬lambda���ʽҲ������Ϊ�հ���  
��������ʽ�ӿ��ǽ�����һ�����󷽷��Ľӿڣ��������ָ���˽ӿڵ�Ŀ����;��ͨ����ʾ������������*Runnable*�ӿڡ�
**���⣬����ʽ�ӿڶ�����lambda���ʽ��Ŀ�����͡��ر�ע�⣬lambda���ʽֻ��������Ŀ�������ѱ�ָ�����������С�**  
> ע�⣺����ʽ�ӿڿ���ָ��Object������κι��з���������equals()������Ӱ������Ϊ������ʽ�ӿڡ���
״̬��Object�Ĺ��з�������Ϊ����ʽ�ӿڵ���ʽ��Ա����Ϊ����ʽ�ӿڵ�ʵ����Ĭ���Զ�ʵ�����ǡ�  
### lambda���ʽ����֪ʶ
����lambda���ʽ��Java������������һ���µ��﷨Ԫ�غ������������������<b>-></b>����Ϊlambda�����
���ͷ�����������lambda���ʽ�ֳ��������֡����ָ����lambda���ʽ��Ҫ�����в������Ҳ���**lambda��**��
��ָ����lambda���ʽ�Ķ��������磺
```
    (n) -> 1.0 / n;
    n -> (n % 2) == 0;
```
### ����ʽ�ӿ�
������ָ��һ�����󷽷��Ľӿڣ����԰���Ĭ�Ϸ�����̬���������������һ���ҽ�����һ�����󷽷���
```java
    interface MyName {
        String getName();
    }
```
������ǰ������lambda���ʽ���Ƕ���ִ�еģ����ǹ�����һ������ʽ�ӿڶ���ĳ��󷽷���ʵ�֣��ú���ʽ�ӿڶ���������
Ŀ�����͡������ֻ���ٶ�����lambda���ʽ��Ŀ�����͵��������У�����ʹ�øñ��ʽ������һ��lambda���ʽ����һ��
����ʽ�ӿ�**����**ʱ���ʹ�����һ�������������ġ�����Ŀ�����������İ���������ʼ����return����
����ʵ�εȡ��Խӿ�*MyName*��ʹ��ʾ����
```
    // myName�Ƕ�MyNameʵ����һ������
    MyName myName = () -> "zzz";
    System.out.println("My name is " + myName.getName())
```
������Ŀ�������������г���lambda���ʽʱ�����Զ�����ʵ���˺���ʽ�ӿڵ�һ�����ʵ��������ʽ�ӿ������ĳ��󷽷�
����Ϊ��lambda���ʽ���塣��ͨ��Ŀ����ø÷���ʱ���ͻ�ִ��lambda���ʽ����ˣ�lambda���ʽ�ṩ��һ�ֽ�����
Ƭ��ת��Ϊ����ķ�����
> ע�⣺Ϊ����Ŀ��������������ʹ��lambda���ʽ�����󷽷������ͺ�lambda�����ͱ�����ݡ�

### ����ʾ��
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
> ע�⣺����Ҫ��ʽ�����βε�����ʱ���б��������βε����Ͷ�������������  
```
    (int n, int d) -> (n % d) == 0; // �Ϸ�
    (int n, int d) -> (n % d) == 0; // �Ƿ�
```
## ��lambda���ʽ
������ͷ�����->�Ҳ�Ĵ��������һ������鹹�ɣ����԰���������䣬�������͵�lambda���Ϊ����(block body)����lambda��
�ڿ�lambda�б�����ʽʹ��һ��return���������ֵ��  
```
    NumberTest numberTest = (n, m) -> {
        boolean result;
        ����;
        return result;
    }
```
## ���ͺ���ʽ�ӿ�
����lambda���ʽ������ָ�������βΣ�lambda���ʽ�����Ƿ��ͣ����ڴ��������ƶϣ�����lambda���ʽ��չ�ֳ�һЩ�����ڷ��͵���������
Ȼ������lambda���ʽ�����ĺ���ʽ�ӿڿ����Ƿ��͵ġ�
```java
    interface Test<T> {
        boolean test(T param1, T param2);
    }
```
������Ϊʵ�δ���lambda���ʽ
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
## lambda���ʽ�ͱ�������
����lambda���ʽ���Ի�ȡ�����������**���ʵ����̬������ֵ**���Լ�����������ඨ��ķ�����
���ǣ���lambda���ʽʹ��������������ڶ���ľֲ�����ʱ�������һ��������������Ϊ��������
ֻ��**ʹ��ʵ����Ϊfinal�ľֲ�����**��lambda���ʽ�����޸�����������ڵľֲ�������
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
> lambda���ʽ����ʹ�ú��޸���������ʵ��������ֻ�ǲ���ʹ��������������еľֲ�������
���Ǹñ���ʵ������final��
## ��������
### ��̬�����ķ�������
������������Ϸ�������ClassName::methodName�������뷽����֮��ʹ��˫ð�ŷָ�����
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
            // ����
        }   
    }
```
### ʵ�������ķ�������
����objRef::methodName���ɷ������������õķ������еĲ�����Ե���objRef��ָ���Է��ͷ����ķ������ã�
```java
    interface SomeTest<T> {
        boolean test(T param1, T param2);
    }
    
    class MyClass {
        static <T> boolean myGenMeth(T x, T y) {
            boolean result = false;
            // ����
            return result;
        }
        SomeTest<Integer> ref = MyClass::<Integer>myGenMeth;
    }
```
## ���췽������
����ClassName::new
## Ԥ����ĺ���ʽ�ӿ�
����������java.util.function���ӿڣ�UnaryOperator<T>��BinaryOperator<T>��Consumer<T>��
Supplier<T>��Function<T, R>��Predicate<T>
������java.util.stream���������ݵĹܵ�������ʾ���ж������������ߣ�pipeline����ִ��һϵ�����
���ݵĶ�������Щ����������lambda���ʽ����ʾ���ⲿ�����ݺ����ٽ��ܡ�

