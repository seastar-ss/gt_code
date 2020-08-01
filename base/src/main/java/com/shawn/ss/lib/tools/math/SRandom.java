/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shawn.ss.lib.tools.math;

import java.util.Random;

/**
 *
 * @author ss
 */
public class SRandom extends Random {

    volatile int prev = 0;

    public int distinctNextInt(int n) {
        int tmp = 1;
        do {
            tmp = super.nextInt(n);
        } while (tmp == prev);
        prev = tmp;
        return tmp;
    }

}
