<#import "components/layout.ftl" as l />
<#import "components/utils.ftl" as u />
<#import "components/mobile-components.ftl" as mobile />

<#escape x as x?html>
<@l.main "page.frontpage">

<#assign imageNumber="1">

<#function rand min max>
  <#local now = .now?long?c />
  <#local randomNum = _rand +
    ("0." + now?substring(now?length-1) + now?substring(now?length-2))?number />
  <#if (randomNum > 1)>
    <#assign _rand = randomNum % 1 />
  <#else>
    <#assign _rand = randomNum />
  </#if>
  <#return (min + ((max - min) * _rand))?round />
</#function>

<#assign _rand = 0.36 />
<#assign imageNumber = rand(1, 4)?c />

<div class="image-container image-${imageNumber} hidden-xs hidden-sm">

</div>

	<@mobile.mobileFrontPageImageContainer imageNumber />


<div class="container">
    <a href="${urls.createNew()}" class="hero-holder noprint">
			<span class="hero"><@u.messageHTML "index.hero" /><i class="icon-front i-arrow-right"></i></span>
    </a>

    <div id="content">
	    <div class="row front-container">
				<div class="col-md-6">
          <div class="front-block">
						<h1><@u.message "index.block-1.title" /></h1>

						<p><@u.message "index.block-1.p-1" /></p>

						<ul>
							<li><@u.message "index.block-1.li-1" /></li>
							<li><@u.message "index.block-1.li-2" /></li>
							<li><@u.message "index.block-1.li-3" /></li>
						</ul>

						<p><@u.message "index.block-1.p-2" /></p>
						<p><@u.message "index.block-1.p-3" /></p>

						<a href="${urls.helpIndex()}" class="block-link"><@u.message "index.block-1.link" /></a>
					</div>
				</div>

        <div class="col-md-6">
					<div class="front-block">
						<i class="icon-front i-list"></i>
							<h2><@u.message "index.block-2.title" /></h2>

							<p><@u.message "index.block-2" /></p>

							<#if initiatives?? && initiatives?size gt 0>
								<ul class="initiative-list no-style">
									<#list initiatives as initiative>
										<li>
											<span class="date"><@u.localDate initiative.startDate /></span>
											<a href="${urls.view(initiative.id)}"><@u.text initiative.name /></a>
										</li>
									</#list>
								</ul>
							</#if>

							<a href="${urls.search()}" class="block-link"><@u.message "index.block-2.link" /></a>
						</div>
						<div class="front-block">
							<i class="icon-front i-help"></i>
							<h2><@u.message "index.block-3.title" /></h2>

							<#assign href1>${urls.helpIndex()}</#assign>
							<#assign href2>${urls.help(HelpPage.CONTACT.getUri(locale))}</#assign>
							<p><@u.messageHTML key="index.block-3.p-1" args=[href1, href2] /></p>
						</div>
				</div>
			</div>
		</div>
</div>

</@l.main>
</#escape>

