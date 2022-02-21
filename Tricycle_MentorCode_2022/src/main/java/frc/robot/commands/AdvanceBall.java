// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ConveyorBelt;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class AdvanceBall extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ConveyorBelt m_conveyorBelt;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public AdvanceBall(ConveyorBelt subsystem) {
    m_conveyorBelt = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_conveyorBelt);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   m_conveyorBelt.advanceBall();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
     
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_conveyorBelt.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
