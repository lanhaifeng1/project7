package cn.edu.hqu.cst.sensordemo;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.BreakIterator;

public class PressureActivity extends AppCompatActivity {
    private TextView tv_value7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        SensorManager sManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor mSensorOrientation = sManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        sManager.registerListener((SensorEventListener) this,sManager.getDefaultSensor(Sensor.TYPE_PRESSURE), SensorManager.SENSOR_DELAY_NORMAL);
        bindViews();
    }
    private void bindViews() {
      tv_value7= (TextView) findViewById(R.id.tv_value7);
    }
    public void onSensorChanged(SensorEvent event) {
        float X = event.values[0];
        tv_value7.setText("压强为"+ X );
    }
}
