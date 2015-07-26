package project.com.gittest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private TextView m_tv5 = null,
            m_tv6 = null,
            m_tv7 = null,
            m_tv8 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViewComponent();
        test();
    }

    private void test() {
        //================ by reference ===============================
        A a1 = new A();
        a1.m_num = 1;
        Log.e("MainActvity a", String.valueOf(a1));
        m_tv5.setText(String.valueOf(a1.m_num));
        B b1 = null;
        b1 = new B(a1);
        b1.setNum(2);
        m_tv6.setText(String.valueOf(a1.m_num));
        //================ clone by address===============================
        A a2 = new A();
        a2.m_num = 1;
        Log.e("MainActvity a",String.valueOf(a2));
        m_tv7.setText(String.valueOf(a2.m_num));
        B b2 = null;
        try {
            b2 = new B((A)a2.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        b2.setNum(2);
        m_tv8.setText(String.valueOf(a2.m_num));
        
    }

    private void setupViewComponent() {
        m_tv5 = (TextView) findViewById(R.id.tv5);
        m_tv6 = (TextView) findViewById(R.id.tv6);
        m_tv7 = (TextView) findViewById(R.id.tv7);
        m_tv8 = (TextView) findViewById(R.id.tv8);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
