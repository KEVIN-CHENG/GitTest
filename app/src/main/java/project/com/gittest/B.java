package project.com.gittest;

import android.util.Log;

/**
 * Created by ¤pºñ»¶´Ô on 2015/7/26.
 */
public class B {
    private A m_a = null;
    B(A a){
        m_a = a;
        Log.e("B m_a",String.valueOf(m_a));
    }
    public void setNum(int i){
        m_a.m_num = i;
    }
}
