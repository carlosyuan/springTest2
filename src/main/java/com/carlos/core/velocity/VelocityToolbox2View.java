package com.carlos.core.velocity;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.context.Context;
import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.ToolManager;
import org.apache.velocity.tools.view.ViewToolContext;
import org.springframework.web.servlet.view.velocity.VelocityLayoutView;

/**
 * spring对最新的velocity tool2.0 的支持不是太好，所以需要扩展viewClass类，才能读取velocitytool.Xml文件。
 在没有使用layout的velocity中，需要可以直接继承VelocityToolboxView类，然后重写createVelocityContext方法，
 但是在VelocityLayoutViewResolver中却无法加载继承VelocityToolboxView的类，而是需要继承VelocityLayoutView，
 去查找源文件的类，发现VelocityLayoutView继承一样VelocityToolboxView类，
 所以直接继承VelocityLayoutView然后重写createVelocityContext方法
 */
public class VelocityToolbox2View extends VelocityLayoutView{
        @Override
        protected Context createVelocityContext(Map<String, Object> model,
                                                HttpServletRequest request, HttpServletResponse response)
                throws Exception {// Create a
                // ChainedContext
                // instance.
                ViewToolContext ctx;

                ctx = new ViewToolContext(getVelocityEngine(), request, response,
                        getServletContext());

                ctx.putAll(model);

                if (this.getToolboxConfigLocation() != null) {
                        ToolManager tm = new ToolManager();
                        tm.setVelocityEngine(getVelocityEngine());
                        tm.configure(getServletContext().getRealPath(
                                getToolboxConfigLocation()));
                        if (tm.getToolboxFactory().hasTools(Scope.REQUEST)) {
                                ctx.addToolbox(tm.getToolboxFactory().createToolbox(
                                        Scope.REQUEST));
                        }
                        if (tm.getToolboxFactory().hasTools(Scope.APPLICATION)) {
                                ctx.addToolbox(tm.getToolboxFactory().createToolbox(
                                        Scope.APPLICATION));
                        }
                        if (tm.getToolboxFactory().hasTools(Scope.SESSION)) {
                                ctx.addToolbox(tm.getToolboxFactory().createToolbox(
                                        Scope.SESSION));
                        }
                }
                return ctx;
        }
}
