import java.util.Objects;

public class CruiseControl {

    private double targetSpeedKmh;

    void setPreset(SpeedPreset speedPreset) {

        Objects.requireNonNull(speedPreset);
        setTargetSpeedKmh(speedPreset.speedKmh);
    }

    void setTargetSpeedKmh(double speed) {
        targetSpeedKmh = speed;
    }
}

// 가능한 옵션을 모두 열거할 수 있다면 항상 enum을 사용하자.
enum SpeedPreset {
    STOP(0),
    PLANETARY_SPEED(7667),
    CRUISE_SPEED(16944);

    final double speedKmh;

    SpeedPreset(double speedKmh) {
        this.speedKmh = speedKmh;
    }

}