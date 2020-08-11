package org.n3r.idworker;

/**
 * @author code.rookie
 */
public interface RandomCodeStrategy {

    void init();

    int prefix();

    int next();

    void release();
}
