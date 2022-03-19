// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Winch extends SubsystemBase {
  /** Creates a new winch subsystem. */
  private final PWMSparkMax m_winch = new PWMSparkMax(7);
  
  public Winch() {
    addChild("Winch", m_winch);
  }

  
  public void raise() {
    m_winch.set(1);
    // Winds cable of winch, raising robot.
  }

  public void unwind() {
    m_winch.set(-0.5);
    // Unwinds winch cable.
  }
 
  public void stop() {
    m_winch.set(0);
  }


  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
