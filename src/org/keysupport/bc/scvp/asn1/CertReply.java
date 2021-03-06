/**
 * The MIT License (MIT)
 * 
 * Copyright (c) 2008-2015 keysupport.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.keysupport.bc.scvp.asn1;

import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x509.Extensions;

/**
 * @author tejohnson
 * 
 * This class is a representation of a CertReply.
 * <pre>
 *       CertReply ::= SEQUENCE {
 *         cert                       CertReference,
 *         replyStatus                ReplyStatus DEFAULT success,
 *         replyValTime               GeneralizedTime,
 *         replyChecks                ReplyChecks,
 *         replyWantBacks             ReplyWantBacks,
 *         validationErrors       [0] SEQUENCE SIZE (1..MAX) OF
 *                                      OBJECT IDENTIFIER OPTIONAL,
 *         nextUpdate             [1] GeneralizedTime OPTIONAL,
 *         certReplyExtensions    [2] Extensions OPTIONAL }
 * </pre>
 *
 * This is where most of the validation action is.  For each
 * certificate that is checked by the SCVP service, this
 * object contains the result of those checks, as well as
 * any other pertinent information defined by policy,
 * or requested by the client.
 *
 * @version $Revision: 1.0 $
 */
public class CertReply extends ASN1Object {

	/*
	 * Memory representation of this object
	 */
	/**
	 * Field value.
	 */
	private ASN1Sequence value;
	/**
	 * Field check.
	 */
	private CertReference cert;
	
	/**
	 * Field replyStatus.
	 */
	private ReplyStatus replyStatus;

	/**
	 * Field replyValTime.
	 */
	private ASN1GeneralizedTime replyValTime;
	
	/**
	 * Field replyChecks.
	 */
	private ReplyChecks replyChecks;
	
	/**
	 * Field replyWantBacks.
	 */
	private ReplyWantBacks replyWantBacks;
	
	/**
	 * Field validationErrors.
	 */
	private ASN1Sequence validationErrors;
	
	/**
	 * Field nextUpdate.
	 */
	private ASN1GeneralizedTime nextUpdate;
	
	/**
	 * Field certReplyExtensions.
	 */
	private Extensions certReplyExtensions;
	/*
	 * The MIN and MAX size of this object
	 */
	/**
	 * Field MIN_OBJ.
	 */
	private int MIN_OBJ = 5;
	/**
	 * Field MAX_OBJ.
	 */
	private int MAX_OBJ = 8;

	@SuppressWarnings("unused")
	private CertReply() {
		//Hiding the default constructor
	}

	/**
	 * Method toASN1Primitive.
	 * @return ASN1Primitive
	 * @see org.bouncycastle.asn1.ASN1Encodable#toASN1Primitive()
	 */
	@Override
	public ASN1Primitive toASN1Primitive() {
		return this.value;
	}

}
