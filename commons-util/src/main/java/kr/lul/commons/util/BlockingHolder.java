package kr.lul.commons.util;

/**
 * 오브젝트가 설정될 때까지 오브젝트를 요청한 스레드를 멈춰두는 홀더.
 *
 * @param <T> 담아둘 오브젝트 타입.
 *
 * @author justburrow
 * @since 2018. 9. 22.
 */
public class BlockingHolder<T> implements CheckableHolder<T>, SettableHolder<T> {
    private final Object[] lock = new Object[0];

    private boolean set;
    private T object;

    public BlockingHolder() {
        this.set = false;
    }

    public BlockingHolder(T object) {
        this.object = object;
        this.set = true;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Holder
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public T get() {
        synchronized (this.lock) {
            if (!this.set) {
                try {
                    this.lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return this.object;
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.CheckableHolder
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean isSet() {
        synchronized (this.lock) {
            return this.set;
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.SettableHolder
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void set(T object) throws IllegalStateException {
        synchronized (this.lock) {
            if (this.set) {
                throw new IllegalStateException("already set.");
            }
            this.object = object;
            this.set = true;
            this.lock.notifyAll();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // java.lang.Object
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String toString() {
        return new StringBuilder(BlockingHolder.class.getSimpleName())
                .append("{set=").append(this.set)
                .append(", object=").append(this.object)
                .append('}').toString();
    }
}
