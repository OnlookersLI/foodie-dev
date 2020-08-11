package org.n3r.idworker;

/**
 * @author code.rookie
 */
public interface WorkerIdStrategy {
    void initialize();

    long availableWorkerId();

    void release();
}
