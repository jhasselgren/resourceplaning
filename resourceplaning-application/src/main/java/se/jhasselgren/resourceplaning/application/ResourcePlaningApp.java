package se.jhasselgren.resourceplaning.application;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import se.jhasselgren.resourceplaning.application.resources.HelloWorldResources;

public class ResourcePlaningApp extends Application<ResourcePlaningAppConfiguration>{

	public static void main(String[] args) throws Exception{
		new ResourcePlaningApp().run(args);
	}
	
	@Override
	public String getName() {
		return "Resource planning";
	};
	
	@Override
	public void initialize(Bootstrap<ResourcePlaningAppConfiguration> bootstrap) {
		bootstrap.addBundle(new AssetsBundle("/app", "/", "index.html", "static"));
//		bootstrap.addBundle(new AssetsBundle("/app/components", "/components", null, "components"));
//		bootstrap.addBundle(new AssetsBundle("/app/bower_components", "/bower_components", null, "bower"));
	}

	@Override
	public void run(ResourcePlaningAppConfiguration configuration,
			Environment environment) throws Exception {
		environment.jersey().setUrlPattern("/api/*");
		environment.jersey().register(new HelloWorldResources());
		
	}
	
	
	
}
