<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:math="http://exslt.org/math"
                version="1.0"
                extension-element-prefixes="math">
    <xsl:output method="xml" encoding="UTF-8" omit-xml-declaration="yes" indent="yes"/>
    <xsl:strip-space elements="*"/>

    <xsl:template match="Items">

        <xsl:for-each select="Item">INSERT INTO ITEM (id, version, discriminator, title, nb_of_discs, rank,
            small_image_url, medium_image_url, language, unit_cost, publication_date, genre_id, label_id, description)
            VALUES (
            <xsl:variable name="i" select="position()+2000"/>
            <xsl:value-of select="$i"/>
            <xsl:text>, 1, 'C', </xsl:text>

            <xsl:if test="ItemAttributes/Title">'
                <xsl:call-template name="escapeQuotes">
                    <xsl:with-param name="txt" select="normalize-space(ItemAttributes/Title)"/>
                </xsl:call-template>
                '
            </xsl:if>
            <xsl:if test="not(ItemAttributes/Title)">null</xsl:if>
            <xsl:text>, </xsl:text>

            <xsl:if test="ItemAttributes/NumberOfDiscs">
                <xsl:value-of select="normalize-space(ItemAttributes/NumberOfDiscs)"/>
            </xsl:if>
            <xsl:if test="not(ItemAttributes/NumberOfDiscs)">null</xsl:if>
            <xsl:text>, </xsl:text>

            <xsl:if test="SalesRank">
                <xsl:value-of select="substring(normalize-space(SalesRank), 1, 1)"/>
            </xsl:if>
            <xsl:if test="not(SalesRank)">null</xsl:if>
            <xsl:text>, </xsl:text>

            <xsl:if test="SmallImage/URL">'<xsl:value-of select="normalize-space(SmallImage/URL)"/>'
            </xsl:if>
            <xsl:if test="not(SmallImage/URL)">null</xsl:if>
            <xsl:text>, </xsl:text>

            <xsl:if test="MediumImage/URL">'<xsl:value-of select="normalize-space(MediumImage/URL)"/>'
            </xsl:if>
            <xsl:if test="not(MediumImage/URL)">null</xsl:if>
            <xsl:text>, </xsl:text>

            <xsl:value-of select="floor(math:random()*8) + 1"/>
            <xsl:text>, </xsl:text>

            <xsl:if test="ItemAttributes/ListPrice/FormattedPrice">
                <xsl:value-of select="substring(normalize-space(ItemAttributes/ListPrice/FormattedPrice), 2, 10)"/>
            </xsl:if>
            <xsl:if test="not(ItemAttributes/ListPrice/FormattedPrice)">null</xsl:if>
            <xsl:text>, </xsl:text>

            <xsl:if test="ItemAttributes/PublicationDate">to_date('<xsl:value-of
                    select="normalize-space(ItemAttributes/PublicationDate)"/>', 'YYYY-MM-DD')
            </xsl:if>
            <xsl:if test="not(ItemAttributes/PublicationDate)">null</xsl:if>
            <xsl:text>, </xsl:text>

            <xsl:value-of select="floor(math:random()*15) + 1000"/>
            <xsl:text>, </xsl:text>

            <xsl:value-of select="floor(math:random()*9) + 1000"/>
            <xsl:text>, </xsl:text>

            <xsl:if test="EditorialReviews/EditorialReview/Content">'
                <xsl:call-template name="escapeQuotes">
                    <xsl:with-param name="txt" select="normalize-space(EditorialReviews/EditorialReview/Content)"/>
                </xsl:call-template>
                '
            </xsl:if>
            <xsl:if test="not(EditorialReviews/EditorialReview/Content)">null</xsl:if>

            <xsl:text>);&#xA;</xsl:text>
        </xsl:for-each>


    </xsl:template>
    <xsl:template match="text()"/>

    <xsl:template name="escapeQuotes">
        <xsl:param name="txt"/>
        <!-- Escape with slash -->
        <!-- <xsl:variable name="backSlashQuote">&#92;&#39;</xsl:variable> -->
        <!-- MsSql escape -->
        <xsl:variable name="backSlashQuote">&#39;&#39;</xsl:variable>
        <xsl:variable name="singleQuote">&#39;</xsl:variable>

        <xsl:choose>
            <xsl:when test="string-length($txt) = 0">
                <!-- ... -->
            </xsl:when>

            <xsl:when test="contains($txt, $singleQuote)">
                <xsl:value-of disable-output-escaping="yes"
                              select="concat(substring-before($txt, $singleQuote), $backSlashQuote)"/>

                <xsl:call-template name="escapeQuotes">
                    <xsl:with-param name="txt" select="substring-after($txt, $singleQuote)"/>
                </xsl:call-template>
            </xsl:when>

            <xsl:otherwise>
                <xsl:value-of disable-output-escaping="yes" select="$txt"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

</xsl:stylesheet>
