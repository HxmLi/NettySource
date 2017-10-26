package io.netty.atest.lock1025;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class mutex implements Lock {
	
	private static class Sync extends AbstractQueuedSynchronizer{
		@Override
		protected boolean isHeldExclusively() {
			return getState() == 1;
		}
		@Override
		protected boolean tryAcquire(int arg) {
			if (compareAndSetState(0, 1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}
		@Override
		protected boolean tryRelease(int arg) {
			if(getState() == 0)
				throw new IllegalMonitorStateException();
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}
	}

	private final Sync sync = new Sync();
	
	@Override
	public void lock() {
		sync.acquire(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
	}

	@Override
	public boolean tryLock() {
		return sync.tryAcquire(1);
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, unit.toNanos(time));
	}
	@Override
	public void unlock() {
		sync.release(1);
	}
	@Override
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}
