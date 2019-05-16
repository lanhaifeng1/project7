package cn.edu.hqu.cst.sensordemo;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GyroscopeActivity extends AppCompatActivity {
    private TextView tv_value1;
    private TextView tv_value2;
    private TextView tv_value3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);
        SensorManager sManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor mSensorOrientation = sManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        sManager.registerListener((SensorEventListener) this,sManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE), SensorManager.SENSOR_DELAY_NORMAL);
        bindViews();
    }
    private void bindViews() {
        tv_value1 = (TextView) findViewById(R.id.tv_value4);
        tv_value2 = (TextView) findViewById(R.id.tv_value5);
        tv_value3 = (TextView) findViewById(R.id.tv_value6);
    }
    public void onSensorChanged(SensorEvent event) {
        float X = (float)Math.toDegrees(event.values[0]);
        float Y = (float)Math.toDegrees(event.values[1]);
        float Z = (float)Math.toDegrees(event.values[2]);
        tv_value1.setText("绕x轴转过的角速度\n"+ X );
        tv_value2.setText("绕y轴转过的角速度\n"+ Y );
        tv_value3.setText("绕z轴转过的角速度\n"+ Z );
    }
}
