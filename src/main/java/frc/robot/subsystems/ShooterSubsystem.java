/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  private final SpeedControllerGroup pew;
  private final Servo shooterHoodServo = new Servo(Constants.PWM.SHOOTER_HOOD_SERVO);
  

  /**
   * Creates a new ShooterSubsystem.
   */
  public ShooterSubsystem() {
    CANSparkMax pewLeft = new CANSparkMax(Constants.SPARK_MAX_CAN.PEW_LEFT_CAN_ID, MotorType.kBrushless);
    CANSparkMax pewRight = new CANSparkMax(Constants.SPARK_MAX_CAN.PEW_RIGHT_CAN_ID, MotorType.kBrushless);
    pewLeft.setInverted(true);

    pew = new SpeedControllerGroup(pewLeft, pewRight);
  }

  public void setAngle(double degrees) {
    shooterHoodServo.setAngle(degrees);
  }

  public void shooter(boolean on, boolean up) {
    if (on) {
      // What to do when the conveyer is ON?
      if (up) {
        pew.set(1);
          } else {
            pew.set(-1);
          }
    } else {
      // What to do when the conveyer is OFF?
      pew.set(0);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
