package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by mjjus on 12/12/2015.
 */
public class Autonomous extends OpMode {

    final static int PULSES_PER_ROTATION = 1440;
    final static int FIRST_DISTANCE_IN_ROTATION = 20;
    final static int SECOND_DISTANCE_IN_ROTATION = 30;
    final static int FIRST_DISTANCE_IN_PULSES = PULSES_PER_ROTATION * FIRST_DISTANCE_IN_ROTATION;
    final static int SECOND_DISTANCE_IN_PULSES = PULSES_PER_ROTATION * SECOND_DISTANCE_IN_ROTATION;

    DcMotor motorRightF;
    DcMotor motorRightB;
    DcMotor motorLeftF;
    DcMotor motorLeftB;

    @Override
    public void init() {

        try {
            motorRightF = hardwareMap.dcMotor.get("frontright");
            motorRightB = hardwareMap.dcMotor.get("backright");
            motorLeftF = hardwareMap.dcMotor.get("frontleft");
            motorLeftB = hardwareMap.dcMotor.get("backleft");

            // TODO: Make sure the motors directions are correct
            motorRightF.setDirection(DcMotor.Direction.FORWARD);
            motorRightB.setDirection(DcMotor.Direction.FORWARD);
            motorLeftF.setDirection(DcMotor.Direction.FORWARD);
            motorLeftB.setDirection(DcMotor.Direction.FORWARD);

            // TODO: Check to make sure the "reset encoders" command works on
            // motors that don't have encoders (only two of the motors on Robot 1
            // have encoders
            motorRightF.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
            motorRightB.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
            motorLeftF.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
            motorRightB.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);












        }catch(Exception e){
            telemetry.addData("",e.getMessage());
        }
    }

    @Override
    public void loop() {

        // 1. Place robot in starting position
        // 2. go forward x rotations
        // 3. if red, rotate 90 counterclockwise
        // else, rotate 90 clockwise
        // 4. go forward y rotations
    }
}
;