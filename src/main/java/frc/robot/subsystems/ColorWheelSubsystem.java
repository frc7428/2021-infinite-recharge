/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ColorWheelSubsystem extends SubsystemBase {
  private final WPI_VictorSPX Wheel = new WPI_VictorSPX(Constants.COLOR_WHEEL_CAN_ID);
  /**
   * Creates a new ColorWheelSubsystem.
   */
  public ColorWheelSubsystem() {
  }

  public void colorWheel(boolean colorWheel) {
    Wheel.set(colorWheel ? 1 : 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
