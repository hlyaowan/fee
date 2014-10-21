package com.aoyetech.fee.commons.utils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 正数的原子递增器，主要用于实现轮询
 * 
 * @author <a href=mailto://wq163@163.com>jenwang</a>
 * @since 2012-12-24 上午11:47:16
 **/

public class PositiveAtomicCounter {
    private final AtomicInteger atom;
    private static final int    mask = 0x7FFFFFFF;


    public PositiveAtomicCounter() {
        this.atom = new AtomicInteger(0);
    }


    public final int incrementAndGet() {
        final int rt = this.atom.incrementAndGet();
        return rt & mask;
    }


    public int intValue() {
        return this.atom.intValue();
    }


    public void set(final int i) {
        this.atom.set(i > 0 ? i : -i);

    }
}
