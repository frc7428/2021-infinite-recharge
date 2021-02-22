// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MecanumDriveSubsystem;

public class POVDriveCommand extends CommandBase {
  private final MecanumDriveSubsystem mDrive;
  private final double mForwardSpeed;
  private final double mRightSpeed;

  /** Creates a new POVDriveCommand. */
  public POVDriveCommand(MecanumDriveSubsystem driveSubsystem, double forwardSpeed, double rightSpeed) {
    // Use addRequirements() here to declare subsystem dependencies.
    mDrive = driveSubsystem;
    mForwardSpeed = forwardSpeed;
    mRightSpeed = rightSpeed;
    addRequirements(mDrive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mDrive.drive(mForwardSpeed, mRightSpeed, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
