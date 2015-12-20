package org.haplo.template.html;

public class Template {
    private NodeList nodes;
    private int numberOfRememberedViews;

    protected Template(NodeList nodes, int numberOfRememberedViews) {
        this.nodes = nodes;
        this.numberOfRememberedViews = numberOfRememberedViews;
    }

    public void render(StringBuilder builder, Driver driver) throws RenderException {
        driver.setupForRender(this.numberOfRememberedViews);
        this.nodes.render(builder, driver, driver.getRootView(), Context.TEXT);
    }

    public void renderAsIncludedTemplate(StringBuilder builder, Driver driver, Object view, Context context) throws RenderException {
        driver.setupForRender(this.numberOfRememberedViews);
        this.nodes.render(builder, driver, view, context);
    }

    public String renderString(Driver driver) throws RenderException {
        StringBuilder builder = new StringBuilder();
        render(builder, driver);
        return builder.toString();
    }

    public String dump() {
        StringBuilder builder = new StringBuilder();
        nodes.dumpToBuilder(builder, "");
        return builder.toString();
    }
}
