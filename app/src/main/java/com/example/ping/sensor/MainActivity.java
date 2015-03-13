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

public class MainActivity extends ActionBarActivity implements SensorListener {

    SensorManager sm = null;

    TextView View1 = null;
    TextView View2 = null;
    TextView View3 = null;
    TextView View4 = null;
    TextView View5 = null;
    TextView View6 = null;
    TextView View7 = null;
    TextView View8 = null;
    TextView View9 = null;
    TextView View10 = null;
    TextView View11 = null;
    TextView View12 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);

        View1 = (TextView) findViewById(R.id.edt1);
        View2 = (TextView) findViewById(R.id.edt2);
        View3 = (TextView) findViewById(R.id.edt3);
        View4 = (TextView) findViewById(R.id.edt4);
        View5 = (TextView) findViewById(R.id.edt5);
        View6 = (TextView) findViewById(R.id.edt6);
        View7 = (TextView) findViewById(R.id.edt7);
        View8 = (TextView) findViewById(R.id.edt8);
        View9 = (TextView) findViewById(R.id.edt9);
        View10 = (TextView) findViewById(R.id.edt10);
        View11 = (TextView) findViewById(R.id.edt11);
        View12 = (TextView) findViewById(R.id.edt12);
    }

    @Override
    public void onSensorChanged(int sensor, float[] values) {
        synchronized (this) {
            String str = "X：" + values[0] + "，Y：" + values[1] + "，Z：" + values[2];
            switch (sensor) {
                case Sensor.TYPE_ACCELEROMETER:
                    View1.setText("Accelerometer：" + str);
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    View2.setText("Magnetic：" + str);
                    break;
                case Sensor.TYPE_ORIENTATION:
                    View3.setText("Orientation：" + str);
                    break;
                case Sensor.TYPE_GYROSCOPE:
                    View4.setText("Gyroscope：" + str);
                    break;
                case Sensor.TYPE_LIGHT:
                    View5.setText("Light：" + str);
                    break;
                case Sensor.TYPE_PRESSURE:
                    View6.setText("Pressure：" + str);
                    break;
                case Sensor.TYPE_TEMPERATURE:
                    View7.setText("Temperature：" + str);
                    break;
                case Sensor.TYPE_PROXIMITY:
                    View8.setText("Proximity：" + str);
                    break;
                case Sensor.TYPE_GRAVITY:
                    View9.setText("Gravity：" + str);
                    break;
                case Sensor.TYPE_LINEAR_ACCELERATION:
                    View10.setText("Linear Acceleration：" + str);
                    break;
                case Sensor.TYPE_ROTATION_VECTOR:
                    View11.setText("Rotation Vector：" + str);
                    break;
                default:
                    View12.setText("Normal：" + str);
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
