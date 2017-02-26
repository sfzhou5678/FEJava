package com.zsf.core;

import com.zsf.expression.Expression;
import com.zsf.model.Region;
import javafx.util.Pair;

import java.util.List;

/**
 * Created by zsf on 2017/2/26.
 */
public class CoreFilterBool extends CoreAlgebra {
    @Override
    public List<Expression> learn(List<Pair<Region, Region>> positiveExamplePairs) {
        // TODO: 2017/2/26 P1=S.learn() [和Map中的S.learn一致]

        // TODO: 2017/2/26 P2=B.learn()

        // TODO: 2017/2/26 P=FilterBool(p1,p2)

        return null;
    }

}
