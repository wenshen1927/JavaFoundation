package _2_behavior_paramlize;

import _1_feature.Apple;

/**
 * 筛选标准谓词
 */
public interface ApplePredicate {
    boolean test(Apple apple);
}
