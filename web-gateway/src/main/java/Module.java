import com.example.auction.bidding.api.BiddingService;
import com.example.auction.item.api.ItemService;
import com.example.auction.search.api.SearchService;
import com.example.auction.transaction.api.TransactionService;
import com.example.auction.user.api.UserService;
import com.lightbend.lagom.javadsl.api.ServiceAcl;
import com.lightbend.lagom.javadsl.api.ServiceInfo;
import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.client.ServiceClientGuiceSupport;
import com.typesafe.config.Config;

public class Module extends AbstractModule implements ServiceClientGuiceSupport {
    @Override
    protected void configure() {
        bindServiceInfo(ServiceInfo.of("web-gateway-module", ServiceAcl.path("(?!/api/).*")));
        // TODO: remove this and the ConfigProvider when upgrading to Lagom 1.4.0
        binder().bind(Config.class).toProvider(ConfigProvider.class);
        bindClient(UserService.class);
        bindClient(ItemService.class);
        bindClient(BiddingService.class);
        bindClient(SearchService.class);
        bindClient(TransactionService.class);
    }
}

