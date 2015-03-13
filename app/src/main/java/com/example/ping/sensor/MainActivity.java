package com.example.ping.sensor;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.widget.TextView;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorListener;

import java.util.List;

public class MainActivity extends ActionBarActivity implements SensorListener {

    private SensorManager sm = null;

    private TextView View0 = null;
    private TextView View1 = null;
    private TextView View2 = null;
    private TextView View3 = null;
    private TextView View4 = null;
    private TextView View5 = null;
    private TextView View6 = null;
    private TextView View7 = null;
    private TextView View8 = null;
    private TextView View9 = null;
    private TextView View10 = null;
    private TextView View11 = null;
    private TextView View12 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View0 = (TextView) findViewById(R.id.tv0);
        View1 = (TextView) findViewById(R.id.tv1);
        View2 = (TextView) findViewById(R.id.tv2);
        View3 = (TextView) findViewById(R.id.tv3);
        View4 = (TextView) findViewById(R.id.tv4);
        View5 = (TextView) findViewById(R.id.tv5);
        View6 = (TextView) findViewById(R.id.tv6);
        View7 = (TextView) findViewById(R.id.tv7);
        View8 = (TextView) findViewById(R.id.tv8);
        View9 = (TextView) findViewById(R.id.tv9);
        View10 = (TextView) findViewById(R.id.tv10);
        View11 = (TextView) findViewById(R.id.tv11);
        View12 = (TextView) findViewById(R.id.tv12);


        //从系统服务中获得传感器管理器
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);

        //从传感器管理器中获得全部的传感器列表   
        List<Sensor> allSensors = sm.getSensorList(Sensor.TYPE_ALL);

        //显示有多少个传感器   
        View0.setText("经检测该手机有" + allSensors.size() + "个传感器，他们分别是：\n");

        //显示每个传感器的具体信息   
        for (Sensor s : allSensors) {
            String tempString = "\n" + "  设备名称：" + s.getName() + "\n" + "  设备版本：" + s.getVersion() + "\n" + "  供应商："
                    + s.getVendor() + "\n";
            switch (s.getType()) {
                case Sensor.TYPE_ACCELEROMETER:
                    View0.setText(View0.getText().toString() + s.getType() + " 加速度传感器accelerometer" + tempString);
                    break;
                case Sensor.TYPE_GYROSCOPE:
                    View0.setText(View0.getText().toString() + s.getType() + " 陀螺仪传感器gyroscope" + tempString);
                    break;
                case Sensor.TYPE_LIGHT:
                    View0.setText(View0.getText().toString() + s.getType() + " 环境光线传感器light" + tempString);
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    View0.setText(View0.getText().toString() + s.getType() + " 电磁场传感器magnetic field" + tempString);
                    break;
                case Sensor.TYPE_ORIENTATION:
                    View0.setText(View0.getText().toString() + s.getType() + " 方向传感器orientation" + tempString);
                    break;
                case Sensor.TYPE_PRESSURE:
                    View0.setText(View0.getText().toString() + s.getType() + " 压力传感器pressure" + tempString);
                    break;
                case Sensor.TYPE_PROXIMITY:
                    View0.setText(View0.getText().toString() + s.getType() + " 距离传感器proximity" + tempString);
                    break;
                case Sensor.TYPE_TEMPERATURE:
                    View0.setText(View0.getText().toString() + s.getType() + " 温度传感器temperature" + tempString);
                    break;
                default:
                    View0.setText(View0.getText().toString() + s.getType() + " 未知传感器" + tempString);
                    break;
            }
        }

    }

    @Override
    public void onSensorChanged(int sensor, float[] values) {
        synchronized (this) {
            String str = "X：" + values[0] + "，Y：" + values[1] + "，Z：" + values[2];
            switch (sensor) {
                case Sensor.TYPE_ACCELEROMETER:
                    View1.setText("Accelerometer(加速度)：\n" + str);
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    View2.setText("Magnetic(磁场)：\n" + str);
                    break;
                case Sensor.TYPE_ORIENTATION:
                    View3.setText("Orientation(定位)：\n" + str);
                    break;
                case Sensor.TYPE_GYROSCOPE:
                    View4.setText("Gyroscope(陀螺仪)：\n" + str);
                    break;
                case Sensor.TYPE_LIGHT:
                    View5.setText("Light(光线)：\n" + str);
                    break;
                case Sensor.TYPE_PRESSURE:
                    View6.setText("Pressure(压力)：\n" + str);
                    break;
                case Sensor.TYPE_TEMPERATURE:
                    View7.setText("Temperature(温度)：\n" + str);
                    break;
                case Sensor.TYPE_PROXIMITY:
                    View8.setText("Proximity(距离)：\n" + str);
                    break;
                case Sensor.TYPE_GRAVITY:
                    View9.setText("Gravity(重力)：\n" + str);
                    break;
                case Sensor.TYPE_LINEAR_ACCELERATION:
                    View10.setText("Linear Acceleration(线性加速度)：\n" + str);
                    break;
                case Sensor.TYPE_ROTATION_VECTOR:
                    View11.setText("Rotation Vector(旋转矢量)：\n" + str);
                    break;
                default:
                    View12.setText("Normal(未知)：\n" + str);
                    break;
            }
        }
    }

    public void onAccuracyChanged(int sensor, int accuracy) {
        Log.d("Sensor", "onAccuracyChanged: " + sensor + ", accuracy: " + accuracy);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this,
                Sensor.TYPE_ACCELEROMETER |
                        Sensor.TYPE_MAGNETIC_FIELD |
                        Sensor.TYPE_ORIENTATION |
                        Sensor.TYPE_GYROSCOPE |
                        Sensor.TYPE_LIGHT |
                        Sensor.TYPE_PRESSURE |
                        Sensor.TYPE_TEMPERATURE |
                        Sensor.TYPE_PROXIMITY |
                        Sensor.TYPE_GRAVITY |
                        Sensor.TYPE_LINEAR_ACCELERATION |
                        Sensor.TYPE_ROTATION_VECTOR,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStop() {
        sm.unregisterListener(this);
        super.onStop();
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
