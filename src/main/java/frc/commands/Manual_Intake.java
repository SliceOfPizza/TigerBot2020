/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;
import frc.subsystems.Intake;

public class Manual_Intake extends CommandBase {
  /**
   * Creates a new Manual_Intake.
   */
  private Joystick m_gamepad;
  private Intake m_intake;
  
  public Manual_Intake ( Intake intake, Joystick gamepad) {
    this.m_intake = intake;
    this.m_gamepad = gamepad; 
    addRequirements(m_intake);
  }

  public Manual_Intake() {
    // Use addRequirements() here to declare subsystem dependencies.
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

    // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    if (m_gamepad.getY(Joystick.Hand.kLeft) > 0.1){
      m_intake.IntakeForwards();
    }
    else if (m_gamepad.getY(Joystick.Hand.kLeft) < -0.1){
      m_intake.IntakeBackwards();
    }
    else {
    m_intake.IntakeStop();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
