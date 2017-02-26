package com.zsf.core;

import com.zsf.expression.Expression;
import com.zsf.model.Region;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsf on 2017/2/26.
 */
public class CoreFilterBool extends CoreAlgebra {
    @Override
    public List<Expression> learn(List<Pair<Region, Region>> positiveExamplePairs) {
        /**
         * 默认分割方式为"split(R 0 ,‘\n’)"，即按行分隔
         */
        List<Expression> expsForSplitingLines=new ArrayList<Expression>();

        // TODO: 2017/2/26 ★★P2=B.learn()(还要处理dynamicTok,不知道要怎么做)


        // TODO: 2017/2/26 P=FilterBool(p1,p2)

        return null;
    }

}
