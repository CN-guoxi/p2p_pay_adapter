package com.qd.p2p.baofoo.param;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import com.qd.p2p.baofoo.IRequestParam;
import com.qd.p2p.baofoo.ServiceStrategy;
import com.qd.p2p.baofoo.enums.Param;
import com.qd.p2p.baofoo.enums.Strategy;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * 提供请求查询参数的抽象类
 * @author linya 2015-11-25
 */
@SuppressWarnings("serial")
public abstract class AbstractRequestParam implements IRequestParam {

    //请求服务名称
    @XStreamOmitField
    private String name;
    
    //请求URL
    @XStreamOmitField
    private String requestUrl;
    
    @XStreamOmitField
    private boolean aesEncrypt;
    
    protected AbstractRequestParam(){
    	parseStrategyAnnotation();
    }
    
    public String getName() {
		return name;
	}

	@Override
	public String getUrlSuffix() {
		return requestUrl;
	}
	

	@Override
	public boolean aesEncrypt() {
		return aesEncrypt;
	}

	private void parseStrategyAnnotation(){
		
		//获取参数对象@Strategy注解
		Strategy strategy = this.getClass().getAnnotation(Strategy.class);
		if(strategy == null){
			throw new IllegalArgumentException("++++ please set @Strategy for " + this.getClass().getName());
		}
		
		//设置注解参数
		ServiceStrategy serviceStrategy = strategy.value();
		this.requestUrl = serviceStrategy.getRequestUrl();
		this.aesEncrypt = strategy.aesEncrypt();
		parseStrategyAnnotation(strategy);
	}
	
	/**
	 * 子类实现注解参数设置(钩子方法)
	 * @param strategy
	 */
	protected void parseStrategyAnnotation(Strategy strategy){}
    
	@Override
    public boolean checkParameter() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field f : fields) {
            Param paramAnnotation = f.getAnnotation(Param.class);
            if (paramAnnotation != null && paramAnnotation.required()) {
                PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(this.getClass(), f.getName());
                if (pd == null) continue;

                Method method = pd.getReadMethod();
                if (method == null) continue;

                Object value = null;
                try {
                    value = method.invoke(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (value == null || StringUtils.isEmpty(value.toString())) {
                    throw new IllegalArgumentException(String.format(" parameter [%s] is required ", f.getName()));
                }
            }
        }

        // 约束check
        if (!restrictCheck()) {
            throw new IllegalArgumentException(" restrict parameter failure ");
        }
        // check strategy
        Strategy strategyAnnotation = this.getClass().getAnnotation(Strategy.class);
        if (strategyAnnotation == null) {
            throw new IllegalArgumentException(" service_strategy is required ");
        }
        return true;
    }

    /**
     * 约束性判断，子类实现
     *
     * @return
     */
    protected boolean restrictCheck() {
        return true;
    }
}
