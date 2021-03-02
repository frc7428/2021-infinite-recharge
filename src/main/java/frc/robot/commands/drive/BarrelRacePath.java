// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.MecanumDriveSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class BarrelRacePath extends SequentialCommandGroup {
  /** Creates a new BarrelRacePath. */
  public BarrelRacePath(MecanumDriveSubsystem drive) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 1.2),
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0.75, 1.8),
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 1.4),
    new AutoDriveWithWaitCommand(drive, 0.75, 0, -0.75, 1.8),
    new AutoDriveWithWaitCommand(drive, 0.75, 0, -0.2, 1),
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 1),
    new AutoDriveWithWaitCommand(drive, 0.75, 0, -0.75, 1.6),
    new AutoDriveWithWaitCommand(drive, 0, 0, -0.75, 1),
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 4.2));
  }
}
