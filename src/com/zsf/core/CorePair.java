package com.zsf.core;

import com.zsf.expression.Expression;
import com.zsf.model.Region;
import javafx.util.Pair;

import java.util.List;

/**
 * Created by zsf on 2017/2/26.
 */
public class CorePair extends CoreAlgebra {
    
    @Override
    public List<Expression> learn(List<Pair<Region, Region>> positiveExamplePairs) {
        return null;
    }
}
