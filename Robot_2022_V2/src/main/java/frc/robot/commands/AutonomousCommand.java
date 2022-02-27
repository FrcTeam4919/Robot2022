// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ConveyorBelt;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class AutonomousCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Shooter m_shooter;
  private final DriveTrain m_drive;
  private final ConveyorBelt m_belt;
  private final Timer m_timer = new Timer();
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public AutonomousCommand(DriveTrain drivetrain, Shooter shooter, ConveyorBelt conveyorbelt) {
    m_drive = drivetrain;
    m_shooter = shooter;
    m_belt = conveyorbelt;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain, shooter, conveyorbelt);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.reset();
    m_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_timer.get() < 3.0){
      m_drive.driveStraight();
    } else if (m_timer.get() < 7.0) {
      //m_shooter.lowGoal();
      m_shooter.highGoal();
      if (m_timer.get() > 4.0) /*(m_timer.get() < 7.0)*/ {
        m_belt.advanceBall();
      }
    } else if (m_timer.get() > 7.0) {
      m_shooter.stop();
      m_belt.stop();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
