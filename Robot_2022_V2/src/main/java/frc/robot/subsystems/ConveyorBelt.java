// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ConveyorBelt extends SubsystemBase {
  /** Creates a new conveyor belt subsystem. */
  private final PWMSparkMax m_belt = new PWMSparkMax(6);
  
  public ConveyorBelt() {
    addChild("Conveyor Belt", m_belt);
  }

  
  public void advanceBall() {
    m_belt.set(-0.5);
    // Moves ball up conveyor belt toward shooter.
  }

  public void reverseBall() {
    m_belt.set(0.5);
    // Moves ball down conveyor belt toward intake.
  }
 
  public void stop() {
    m_belt.set(0);
  }


  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
