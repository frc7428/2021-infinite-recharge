/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsytem extends SubsystemBase {
  private final CANSparkMax intake = new CANSparkMax(Constants.SPARK_MAX_CAN.INTAKE_CAN_ID, MotorType.kBrushless);
  
  /**
   * Creates a new IntakeSubsytem.
   */
  public IntakeSubsytem() {
  }

  public void intake(boolean on, boolean up) {
    if (on) {
      // What to do when the intake is ON?
      if (up) {
        intake.set(1);
          } else {
            intake.set(-1);
          }
    } else {
      // What to do when the intake is OFF?
      intake.set(0);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
