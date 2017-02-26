package com.zsf;

import com.zsf.core.CoreAlgebra;
import com.zsf.core.CoreMerge;
import com.zsf.core.CorePair;
import com.zsf.expression.Expression;
import com.zsf.model.Region;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        List<Pair<Region, Region>> positiveExamplePairs = new ArrayList<Pair<Region, Region>>();
        for (Region positiveRegion : positiveRegions) {
            positiveExamplePairs.add(new Pair<Region, Region>(curRegion, positiveRegion));
        }

        // 根据fig.7 这里的N1指代Merge
        CoreAlgebra N1 = new CoreMerge();
        List<Expression> learnedExpressions = N1.learn(positiveExamplePairs);
//        List<Expression> learnedExpressions = learnSeqRegionsProgFromExamples(positiveExamplePairs);
        for (Expression expression : learnedExpressions) {
            if (isViolatingNegativeRegions()) {
                continue;
            }
            expressions.add(expression);
        }
        return expressions;
    }


    /**
     * 从ExamplePairs中学得符合条件的programs
     *
     * @param positiveExamplePairs example集合，每一个example包括父Region以及待提取Region(output,target)
     * @return
     */
    private List<Expression> learnSeqRegionsProgFromExamples(List<Pair<Region, Region>> positiveExamplePairs) {
        List<Expression> expressions = new ArrayList<Expression>();
        // TODO: 2017/2/26 C.learn? N.RHS?
        // TODO ++ performs  list concatenation??
        // N.RHS可能表示Map、Fileter、merge、pair4种核心函数
//        foreach C ∈ N.RHSs:
//            P := P ++C.Learn(Q)

        // TODO: 2017/2/26 sort Porgrams
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

        List<Pair<Region, Region>> positiveExamplePairs = new ArrayList<Pair<Region, Region>>();
        positiveExamplePairs.add(new Pair<Region, Region>(curRegion,outputRegion));
        // 根据fig.7 这里的N2指代pair，等同于FlashFill
        CoreAlgebra N2=new CorePair();
        expressions=N2.learn(positiveExamplePairs);
//        expressions = FlashFill.learn(curRegion, outputRegion);

        return expressions;
    }
}
