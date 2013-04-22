package us.codecraft.spider.schedular;

import org.apache.log4j.Logger;
import us.codecraft.spider.downloader.Request;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * User: cairne
 * Date: 13-4-21
 * Time: 下午1:13
 */
public class QueueSchedular implements Schedular {

    private Logger logger = Logger.getLogger(getClass());

    private BlockingQueue<Request> queue = new LinkedBlockingQueue<Request>();

    private Set<String> urls = new HashSet<String>();

    @Override
    public synchronized void push(Request request) {
        logger.info("push to queue "+request.getUrl());
        if (urls.add(request.getUrl())){
            queue.add(request);
        }

    }

    @Override
    public synchronized Request poll() {
        return queue.poll();
    }
}
