package eating;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * ehcache example
 * @author hk
 *
 */
public class HelloEhchache {

	public static void main(String[] args) {
		//1. Create a cache manager
		CacheManager cm = CacheManager.getInstance();
		
		//2.Create a cache called "cache1"
		cm.addCache("cache1");
		
		// 3.Get a cache called 
		Cache cache = cm.getCache("cache1");
		
		//4. Put few elements in cache
		cache.put(new Element("1","Jan"));
		cache.put(new Element("2","Feb"));
		cache.put(new Element("3","Mar"));
		
		//5. Get element from cache
		Element ele = cache.get("1");
	}
}
