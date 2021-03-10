// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ConveyerSubsystem;
import frc.robot.subsystems.MecanumDriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class PathARed extends SequentialCommandGroup {
  /** Creates a new PathARed. */
  public PathARed(MecanumDriveSubsystem drive, ConveyerSubsystem convey, ShooterSubsystem shoot) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new AutoDriveWithWaitConveyerAndShooterCommand(drive, 0.75, 0, 0, 0.6, convey, true, true, shoot), //First Forward
    new AutoDriveWithWaitCommand(drive, 0, 0, 0.75, 0.22),
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 1.5), // First Turn
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 0.7),
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 0.2),
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 0.5), // Third Forward
    new AutoDriveWithWaitCommand(drive, 0, 0, -0.75, 0.72), // Third Turn
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 1.4),
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 0.2),
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 0.7),
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 0.2), // Fourth Forward
    new AutoDriveWithWaitCommand(drive, 0, 0, 0.75, 0.5), // Foruth Turn
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 3)); // Final Forward
  }
}
