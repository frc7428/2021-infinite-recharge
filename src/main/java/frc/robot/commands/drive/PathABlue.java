// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;
import frc.robot.subsystems.ConveyerSubsystem;
import frc.robot.subsystems.MecanumDriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class PathABlue extends SequentialCommandGroup {
  /** Creates a new PathABlue. */
  public PathABlue(MecanumDriveSubsystem drive, ConveyerSubsystem convey, ShooterSubsystem shoot) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new AutoDriveWithWaitConveyerAndShooterCommand(drive, 0.75, 0, 0, 0.85, convey, true, true, shoot), // First Forward
    new AutoDriveWithWaitCommand(drive, 0, 0, 0.75, 0.28), //First Turn
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 2.9),
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 0.5), //Second Forward 
    new AutoDriveWithWaitCommand(drive, 0, 0, -0.75, 0.73), //Second Turn
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 1.7),
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 0.3), // Third Forward 
    new AutoDriveWithWaitCommand(drive, 0, 0, 0.75, 0.65), // Fourth Turn 
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 1),
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 0.5),
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 1.5)); //Fourth Forward
  }
}
