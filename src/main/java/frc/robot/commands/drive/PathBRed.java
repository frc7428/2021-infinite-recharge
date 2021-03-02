// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.MecanumDriveSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class PathBRed extends SequentialCommandGroup {
  /** Creates a new PathBRed. */
  public PathBRed(MecanumDriveSubsystem drive) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 1), 
    new AutoDriveWithWaitCommand(drive, 0, 0.75, 0, 2), //B3 17.5 B7 & B8 17.625 
    new AutoDriveWithWaitCommand(drive, 0, -0.75, 0, 1),
    new AutoDriveWithWaitCommand(drive, 0, 0.75, 0, 0.5), 
    new AutoDriveWithWaitCommand(drive, 0.75, 0,  0, 2));
  }
}
