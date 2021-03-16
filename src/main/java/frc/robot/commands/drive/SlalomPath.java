// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.MecanumDriveSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SlalomPath extends SequentialCommandGroup {
  /** Creates a new SlalomPath. */
  public SlalomPath(MecanumDriveSubsystem drive) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 1.2), // Forward 1
    new AutoDriveWithWaitCommand(drive, 0, 0, -0.75, 0.45),// Left Turn 1
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 1.5),// Forward 2
    new AutoDriveWithWaitCommand(drive, 0, 0, 0.75, 0.45),// Right Turn 1
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 3.6),// Forward 3
    new AutoDriveWithWaitCommand(drive, 0, 0, 0.75, 0.6),// Right Turn 2 
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 1.5),// Forward 4
    new AutoDriveWithWaitCommand(drive, 0, 0, -0.75, 0.6),// Left Turn 2
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 1.2),// Forward 5
    new AutoDriveWithWaitCommand(drive, 0, 0, -0.75, 0.5),// Left Turn 3
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 1.3),// Forward 6
    new AutoDriveWithWaitCommand(drive, 0, 0, -0.75, 0.6),// Left Turn 4
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 1.3),// Forward 7
    new AutoDriveWithWaitCommand(drive, 0, 0, -0.75, 0.5),// Right Turn 5
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 1.2),
    new AutoDriveWithWaitCommand(drive, 0, 0, 0.75, 0.45),// Forward 8
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 3.3),// Right Turn 4
    new AutoDriveWithWaitCommand(drive, 0, 0, 0.75, 0.55),// Forward 9
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 1.4),// Left Turn 6
    new AutoDriveWithWaitCommand(drive, 0, 0, -0.75, 0.5),
    new AutoDriveWithWaitCommand(drive, 0.75, 0, 0, 0.5));
  }
}
