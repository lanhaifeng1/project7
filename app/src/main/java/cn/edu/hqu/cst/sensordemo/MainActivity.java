package cn.edu.hqu.cst.sensordemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ARouter.openLog();
        ARouter.openDebug();//由于ARouter会缓存，打开才能即使更新页面
        ARouter.init(getApplication());
        ButterKnife.bind(this);
    }
    @OnClick({R.id.btn_main_gravity,R.id.btn_main_linear_accel,R.id.btn_main_ambient_temp})
    void SensorTest(View v){
        switch (v.getId()){
            case R.id.btn_main_gravity:
            { Intent intent1 = new Intent(this, GyroscopeActivity.class);
                startActivity(intent1);}
            case R.id.btn_main_linear_accel:
            { Intent intent2 = new Intent(this, PressureActivity.class);
                startActivity(intent2);}
            case R.id.btn_main_ambient_temp:
            { Intent intent3 = new Intent(this, DirectionActivity.class);
                startActivity(intent3);}
                break;
        }
    }
}
