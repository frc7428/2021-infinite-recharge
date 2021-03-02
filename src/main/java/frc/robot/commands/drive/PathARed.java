// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.MecanumDriveSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class PathARed extends SequentialCommandGroup {
  /** Creates a new PathARed. */
  public PathARed(MecanumDriveSubsystem drive) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 0.6), //First Forward
    new AutoDriveWithWaitCommand(drive, 0, 0, 0.75, 0.22), // First Turn
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 2.25), // Second Forward
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 0.6), // Third Forward
    new AutoDriveWithWaitCommand(drive, 0, 0, -0.75, 0.72), // Third Turn
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 2.3), // Fourth Forward
    new AutoDriveWithWaitCommand(drive, 0, 0, 0.75, 0.5), // Foruth Turn
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 3)); // Final Forward
  }
}
