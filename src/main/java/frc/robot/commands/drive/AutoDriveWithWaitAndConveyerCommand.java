// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.conveyer.AutoConveyerCommand;
import frc.robot.subsystems.ConveyerSubsystem;
import frc.robot.subsystems.MecanumDriveSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoDriveWithWaitAndConveyerCommand extends ParallelRaceGroup {
  /** Creates a new AutoDriveWithWaitAndConveyerCommand. */
  public AutoDriveWithWaitAndConveyerCommand(MecanumDriveSubsystem drive, double forwardSpeed, 
  double rightSpeed, double clockwiseSpeed, double timeSeconds, 
  ConveyerSubsystem convey, boolean on, boolean up) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new AutoDriveCommand(drive, forwardSpeed, rightSpeed, clockwiseSpeed), 
    new WaitCommand(timeSeconds),
    new AutoConveyerCommand(convey, on, up));
  }
}
