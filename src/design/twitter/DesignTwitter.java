package design.twitter;

import java.util.*;

/**
 * 355. Design Twitter
 * 链接：https://leetcode-cn.com/problems/design-twitter/
 * Created by Michael Allan on 2020/4/13.
 */
public class DesignTwitter {

    public static void main(String[] args) {
        Twitter twitter = new DesignTwitter().new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        List<Integer> res1 = twitter.getNewsFeed(1);
        System.out.println(res1);
//        System.out.println(twitter.getClass());
//        twitter.postTweet(1, 5);
//        List<Integer> res1 = twitter.getNewsFeed(1);
//        System.out.println(res1);
//
//        twitter.follow(1, 2);
//        twitter.postTweet(2, 6);
//        List<Integer> res2 = twitter.getNewsFeed(1);
//        System.out.println(res2);
//
//        twitter.unfollow(1, 2);
//        List<Integer> res3 = twitter.getNewsFeed(1);
//        System.out.println(res3);

    }

    class Twitter {
        /** store user's twitters */
        private final Map<Integer, List<TweetInfo>> userTwitterMap = new HashMap<>();

        /**
         * user follows the other users and the followee can't be the same
         * key: the user
         * value: followees
         */
        private final Map<Integer, Set<Integer>> followeeMap = new HashMap<>();

        private final int capacity;

        /** Initialize your data structure here. */
        public Twitter() {
            this.capacity = 10;
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            List<TweetInfo> tweetInfoList = userTwitterMap.get(userId);
            TweetInfo tweetInfo = new TweetInfo(tweetId);
            if(tweetInfoList == null) {
                tweetInfoList = new ArrayList<>();
                tweetInfoList.add(tweetInfo);
                userTwitterMap.put(userId, tweetInfoList);
            }else {
                tweetInfoList.add(tweetInfo);
            }
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<TweetInfo> priorityQueue = new PriorityQueue<>(capacity);

            Set<Integer> followeeIdSet = followeeMap.get(userId);
            Set<Integer> followeeIdSetBak = new HashSet();
            if(followeeIdSet != null) {
                followeeIdSetBak.addAll(followeeIdSet);
            }
            followeeIdSetBak.add(userId);
            int count = 0;
            for (Integer id : followeeIdSetBak) {
                List<TweetInfo> userTweetInfos = userTwitterMap.get(id);
                if (userTweetInfos == null) {
                    continue;
                } else {
                    for (TweetInfo userTweetInfo : userTweetInfos) {
                        if (count <= capacity) {
                            // 优先级队列priorityQueue初始化10个元素
                            priorityQueue.add(userTweetInfo);
                            count++;
                        } else {
                            // 比较，取最新的
                            if (userTweetInfo.time >= priorityQueue.peek().time) {
                                priorityQueue.poll();
                                priorityQueue.add(userTweetInfo);
                            }
                        }
                    }
                }
            }
            List<Integer> res = new ArrayList<>();
            Iterator<TweetInfo> iterator = priorityQueue.iterator();
            while (iterator.hasNext()) {
                TweetInfo info = iterator.next();
                res.add(info.tweetId);
            }

            return res;
        }

        // 用户存在，但是并未发表过 twitter
        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            // 被这个用户关注的人
            Set<Integer> followeeSet = followeeMap.get(followerId);
            if (followeeSet == null) {
                followeeSet = new HashSet<>();
                followeeSet.add(followeeId);
                followeeMap.put(followerId, followeeSet);
            } else {
                followeeSet.add(followeeId);
            }
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            Set<Integer> followeeSet = followeeMap.get(followerId);
            if (followeeSet == null) {
                // 用户没有关注的人
                return;
            } else {
                followeeSet.remove(followeeId);
            }
        }


        private class TweetInfo implements Comparable<TweetInfo>{
            private int tweetId;

            private long time;

            public TweetInfo(int tweetId) {
                this.tweetId = tweetId;
                this.time = System.currentTimeMillis();
            }

            public int compareTo(TweetInfo tweetInfo) {
                // 降序，维护大根堆
                return -Long.valueOf(time).compareTo(tweetInfo.time);
            }

        }
    }
}
