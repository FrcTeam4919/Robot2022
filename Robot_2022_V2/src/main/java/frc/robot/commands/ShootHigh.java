// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import edu.wpi.first.wpilibj.Timer;

/** A high goal shoot command that uses shooter subsystem. */
public class ShootHigh extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Shooter m_shooter;
  //private final Timer m_timer = new Timer();

  /**
   * Creates a new high goal shoot command.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ShootHigh(Shooter subsystem) {
    m_shooter = subsystem;
    // Uses shooter subsytem.
    addRequirements(m_shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   //m_timer.reset();
   //m_timer.start();
    m_shooter.highGoal();
   
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   /* if (m_timer.get() < 5.0) {
      m_shooter.highGoal();
    }
    else {
      m_shooter.stop();
      m_timer.stop();
      end(true);}*/
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooter.stop();
    //m_timer.reset();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
