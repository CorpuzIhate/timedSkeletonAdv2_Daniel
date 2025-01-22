// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  
  private TalonFX leftMaster  = new TalonFX(3);
  private TalonFX rightMaster  = new TalonFX(1);
  private VictorSP leftSlave  = new VictorSP(1);
  private VictorSP rightSlave  = new VictorSP(2);

  private TalonFX armMotor = new TalonFX(5);
  private VictorSP armSlave = new VictorSP(5);

  private TalonFX rollerMotor = new TalonFX(4);

  private Compressor compressor = new Compressor();
  private DoubleSolenoid hatchIntake = new DoubleSolenoid(0, 1); // PCM port 0, 1

  // Joysticks
  private Joystick driverJoystick = new Joystick(0);
  private Joystick operatorJoystick = new Joystick(1);
   
  public Robot() {}

  @Override
  public void robotPeriodic() {
    // Inverted controls
    leftMaster.setInverted(true);
    rightMaster.setInverted(true);
    armMotor.setInverted(false);

    // Slave setups
    leftSlave.addFollower(leftMaster);
    rightSlave.addFollower(rightMaster);
    armSlave.addFollower(armMotor);

    leftSlave.setInverted(InvertType.FollowMaster);
    rightSlave.setInverted(InvertType.FollowMaster);
    armSlave.setInverted(InvertType.FollowMaster);

    // Initiallize encoders
    //leftMaster.
  }

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {}

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
