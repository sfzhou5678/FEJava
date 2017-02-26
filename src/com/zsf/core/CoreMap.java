package com.zsf.core;

import com.zsf.expression.Expression;
import com.zsf.model.Region;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsf on 2017/2/26.
 */
public class CoreMap extends CoreAlgebra{
    @Override
    public List<Expression> learn(List<Pair<Region, Region>> positiveExamplePairs) {
        Region parentRegion=positiveExamplePairs.get(0).getKey();

        List<List<Expression>> witnesses=new ArrayList<List<Expression>>();
        for (Pair<Region, Region> example:positiveExamplePairs){
            // TODO: 2017/2/26  对每一个examples[i]，首先找到target[i]的所在行，并且将newTarget[i]设为target[i]所在行整行内容
            Region line=example.getLine();
            // TODO: 2017/2/26 ★★然后利用类似FlashFill的方法(但不完全相同)找到所有newTarget[i]的方法(即找出此行的特征),记作witness[i]
            witnesses.add(getExpsForExtractingLine(parentRegion,line));
        }
        // TODO: 2017/2/26 Q1 & F.learn()??
        // TODO: 2017/2/26 witness不一定通用，所以依次将witness[i][j]作用于Region从而得到Region中的某一行Lij,
        // TODO 再将Lij和期望输出Yi一起送到FlashFill中搜寻结果
        /**
         * witnesses中存储的并不一定是有效的exp，经过筛选后将有效的exp存入validWitnesses
         */
        List<List<Expression>> validWitnesses=new ArrayList<List<Expression>>();
        for (int i=0;i<positiveExamplePairs.size();i++){
            List<Expression> curWitnesses=witnesses.get(i);
            List<Expression> curValidWitnesses=new ArrayList<Expression>();
            for (int j=0;j<curWitnesses.size();j++){
                Region selectedRegion=parentRegion.select(curWitnesses.get(j));
                Region targetRegion=positiveExamplePairs.get(i).getValue();

                List<Expression> curExpressions= FlashFill.getValidExpressions(selectedRegion,targetRegion);
                // TODO: 2017/2/26 最后筛选结果,去掉错误的witness和错误的FFExps
                if (curExpressions.size()==0){
                    // 若此方法无解
                    continue;
                }
//                curValidWitnesses.add();
            }
        }

        // TODO: 2017/2/26 Q2 & S.learn()??

        // TODO: 2017/2/26 map(q1,q2)
        List<Expression> expressions=new ArrayList<Expression>();
        return expressions;
    }

    private List<Expression> getExpsForExtractingLine(Region parentRegion, Region line) {
        return null;
    }

}
