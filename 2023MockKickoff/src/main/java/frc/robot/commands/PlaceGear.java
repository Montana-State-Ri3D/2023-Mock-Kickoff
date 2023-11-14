// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GearIntake;

public class PlaceGear extends CommandBase {

  private final GearIntake subsystem;
  private long initTime = -1;
  private final long placeDuration = 500;

  /** Creates a new PlaceGear. */
  public PlaceGear(GearIntake subsystem) {
    
    this.subsystem = subsystem;
    addRequirements(subsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    subsystem.setMotorPower(0.3);
    initTime = System.currentTimeMillis();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    subsystem.setMotorPower(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    long currentTime = System.currentTimeMillis();
    if (currentTime >= initTime + placeDuration)
      return true;
    else;
      return false;
  }
}
