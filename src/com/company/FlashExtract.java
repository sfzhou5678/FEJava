package com.company;

import com.company.expression.Expression;
import com.company.model.Region;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsf on 2017/2/25.
 */
public class FlashExtract {


    /**
     * 获得能够从curRegion中根据positiveRegions和NegativeRegions提取目标region的程序集合
     *
     * @param curRegion       当前父Region，没有选中则为Ω
     * @param positiveRegions 必须要满足的region
     * @param negativeRegions
     * @return 符合要求的程序集合
     */
    public List<Expression> synthesizeSeqRegionProg(Region curRegion,
                                                    List<Region> positiveRegions,
                                                    List<Region> negativeRegions) {
        List<Expression> expressions = new ArrayList<Expression>();

        List<Expression> learnedExpressions = learnFromPositiveRegions();
        for (Expression expression : learnedExpressions) {
            if (isViolatingNegativeRegions()) {
                continue;
            }
            expressions.add(expression);
        }
        return expressions;
    }

    /**
     * 等同于FlashFill的IO Example问题
     *
     * @param curRegion    当前父区域，等价于input
     * @param outputRegion 期望输出
     * @return
     */
    public List<Expression> synthesizeRegionProg(Region curRegion,
                                                 Region outputRegion) {
        List<Expression> expressions = new ArrayList<Expression>();

        expressions = FlashFill.learn(curRegion, outputRegion);

        return expressions;
    }
}
