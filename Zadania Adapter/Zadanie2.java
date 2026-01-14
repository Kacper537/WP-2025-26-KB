interface TemperatureSensor {
    double getTemperatureCelsius();
}

class KelvinSensor {
    public double getTemperatureKelvin() {
        return 300.0; 
    }
}

class FahrenheitSensor {
    public double getTemperatureFahrenheit() {
        return 86.0; 
    }
}

class KelvinSensorAdapter implements TemperatureSensor {
    private KelvinSensor sensor;

    public KelvinSensorAdapter(KelvinSensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public double getTemperatureCelsius() {
        return sensor.getTemperatureKelvin() - 273.15;
    }
}

class FahrenheitSensorAdapter implements TemperatureSensor {
    private FahrenheitSensor sensor;

    public FahrenheitSensorAdapter(FahrenheitSensor sensor) {
        this.sensor = sensor;
    }

    public double getTemperatureCelsius() {
        return (sensor.getTemperatureFahrenheit() - 32) * 5 / 9;
    }
}

public class Zadanie2 {
    public static void main(String[] args) {

        TemperatureSensor sensorKelvin =
                new KelvinSensorAdapter(new KelvinSensor());

        TemperatureSensor sensorFahrenheit =
                new FahrenheitSensorAdapter(new FahrenheitSensor());

        System.out.println("Temperatura z czujnika Kelvina: "
                + sensorKelvin.getTemperatureCelsius() + " st. C");

        System.out.println("Temperatura z czujnika Fahrenheita: "
                + sensorFahrenheit.getTemperatureCelsius() + " st. C");
    }
}
